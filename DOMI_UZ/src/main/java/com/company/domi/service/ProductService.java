package com.company.domi.service;

import com.company.domi.dto.product.ProductDTO;
import com.company.domi.entity.Attachment;
import com.company.domi.entity.AttachmentContent;
import com.company.domi.entity.ProductEntity;
import com.company.domi.enums.ProductType;
import com.company.domi.repository.AttachmentContentRepository;
import com.company.domi.repository.AttachmentRepository;
import com.company.domi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private DescriptionService descriptionService;

    @Autowired
    private PurchasedProductsService purchasedProductsService;

    @Autowired
    AttachmentRepository attachmentRepository;

    @Autowired
    AttachmentContentRepository attachmentContentRepository;

    public ProductDTO create(ProductDTO dto) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setName(dto.getName());
        productEntity.setKamer(dto.getKamer());
        productEntity.setPrice(dto.getPrice());
        productEntity.setCreditPrice(dto.getCreditPrice());
        productEntity.setCreator(dto.getCreator());
        productEntity.setDescription(dto.getDescriptionId());
        productEntity.setCount(dto.getCount());
        productEntity.setTypeOfProduct(dto.getTypeOfProduct());
        productEntity.setExpDate(dto.getExp_date());
        if (dto.getImage()!=null) {
            Attachment attachment = new Attachment();
            attachment.setName(dto.getImage().getOriginalFilename());
            attachment.setSize(dto.getImage().getSize());
            attachment.setContent_type(dto.getImage().getContentType());
            Attachment save = attachmentRepository.save(attachment);
            AttachmentContent attachmentContent = new AttachmentContent();
            attachmentContent.setAttachment(save);
            try {
                attachmentContent.setBytes(dto.getImage().getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
            attachmentContentRepository.save(attachmentContent);
            productEntity.setImage(attachment);
        }
        productEntity.setProductType(dto.getProductType());

        productRepository.save(productEntity);
        dto.setId(productEntity.getId());
        return dto;
    }


    public ProductEntity get1() {
        ProductEntity optional = productRepository.findAllByProductType1();
        return optional;
    }

    public ProductEntity get2() {
        ProductEntity optional = productRepository.findAllByProductType2();
        return optional;
    }

    public ProductEntity get3() {
        ProductEntity optional = productRepository.findAllByProductType3();
        return optional;
    }

    public ProductEntity get4() {
        ProductEntity optional = productRepository.findAllByProductType4();
        return optional;
    }

    public ProductEntity get5() {
        ProductEntity optional = productRepository.findAllByProductType6();
        return optional;
    }

    public ProductEntity get6() {
        ProductEntity optional = productRepository.findAllByProductType7();
        return optional;
    }

    public ProductEntity get7() {
        ProductEntity optional = productRepository.findAllByProductType8();
        return optional;
    }

    public ProductEntity get8() {
        ProductEntity optional = productRepository.findAllByProductType9();
        return optional;
    }

    public ProductEntity get9() {
        ProductEntity optional = productRepository.findAllByProductType10();
        return optional;
    }

    public ProductEntity get10() {
        ProductEntity optional = productRepository.findAllByProductType11();
        return optional;
    }

    public ProductEntity get11() {
        ProductEntity optional = productRepository.findAllByProductType12();
        return optional;
    }

    public ProductEntity get12() {
        ProductEntity optional = productRepository.findAllByProductType13();
        return optional;
    }

    public ProductEntity get13() {
        ProductEntity optional = productRepository.findAllByProductType14();
        return optional;
    }

    public void buyProduct(Integer id,String location,String phone){
        ProductEntity productEntity=get(id);
        purchasedProductsService.create(productEntity,location,phone);
    }

    public ProductEntity get(Integer id) {
        Optional<ProductEntity> optional = productRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        throw new RuntimeException("not found");
    }

    public ProductEntity getAll() {
        List<ProductEntity> optional = productRepository.findAll();
        if (optional!=null) {
            for(ProductEntity productEntity:optional) {
                return productEntity;
            }
        }
        throw new RuntimeException("not found");
    }

    public ProductEntity findbyName() {
       List<ProductEntity> optional = productRepository.orderByName(ProductType.Televizorlar);
        if (optional!=null) {
            for(ProductEntity productEntity:optional) {
                return productEntity;
            }
        }
        throw new RuntimeException("not found");
    }

    public ProductEntity avvalArzonlari() {
        List<ProductEntity> optional = productRepository.avvalArzonlari(ProductType.Televizorlar);
        if (optional!=null) {
            for(ProductEntity productEntity:optional) {
                return productEntity;
            }
        }
        throw new RuntimeException("not found");
    }

    public ProductEntity avvalQimmatlari() {
        List<ProductEntity> optional = productRepository.avvalArzonlari(ProductType.Televizorlar);
        if (optional!=null) {
            for(ProductEntity productEntity:optional) {
                return productEntity;
            }
        }
        throw new RuntimeException("not found");
    }

    public ProductEntity findByPrice(Long price) {
        List<ProductEntity> optional = productRepository.findByPrice(price);
        if (optional!=null) {
            for(ProductEntity productEntity:optional) {
                return productEntity;
            }

        }
        throw new RuntimeException("not found");
    }

    public ProductEntity findByDescription(String description) {
        List<ProductEntity> optional = productRepository.findByDescription(description);
        if (optional!=null) {
            for(ProductEntity productEntity:optional) {
                return productEntity;
            }
        }
        throw new RuntimeException("not found");
    }

    public String delete(Integer id){
        productRepository.deleteById(id);
        return "Deleted";
    }

    public void update(ProductDTO dto){
        ProductEntity productEntity=new ProductEntity();
        productEntity.setCount(dto.getCount());
        if (dto.getImage().isEmpty()) {
            productEntity.setImage(null);
        } else {
            if (productEntity.getImage() == null) {
                Attachment attachment = new Attachment();
                attachment.setName(dto.getImage().getOriginalFilename());
                attachment.setSize(dto.getImage().getSize());
                attachment.setContent_type(dto.getImage().getContentType());
                Attachment save = attachmentRepository.save(attachment);
                AttachmentContent attachmentContent = new AttachmentContent();
                attachmentContent.setAttachment(save);
                try {
                    attachmentContent.setBytes(dto.getImage().getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                attachmentContentRepository.save(attachmentContent);
                productEntity.setImage(attachment);
            } else {
                Optional<Attachment> optionalAttachment = attachmentRepository.findById(productEntity.getImage().getId());
                if (optionalAttachment.isEmpty()) return;
                Attachment attachment = optionalAttachment.get();
                attachment.setName(dto.getImage().getOriginalFilename());
                attachment.setSize(dto.getImage().getSize());
                attachment.setContent_type(dto.getImage().getContentType());
                Attachment save = attachmentRepository.save(attachment);
                Optional<AttachmentContent> optionalAttachmentContent =
                        attachmentContentRepository.findByAttachment_id(save.getId());
                AttachmentContent attachmentContent;
                if (optionalAttachmentContent.isEmpty()) {
                    attachmentContent = new AttachmentContent();
                } else {
                    attachmentContent = optionalAttachmentContent.get();
                }
                try {
                    attachmentContent.setBytes(dto.getImage().getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                attachmentContentRepository.save(attachmentContent);
            }
        }
        productEntity.setPrice(dto.getPrice());
        productEntity.setExpDate(dto.getExp_date());
        productEntity.setName(dto.getName());
        productEntity.setProductType(dto.getProductType());
        productRepository.save(productEntity);
        return;
    }

    public ProductEntity findByType(ProductType productType){
        List<ProductEntity> optional = productRepository.findAllByProductType(productType);
        if (optional!=null) {
            for(ProductEntity productEntity:optional) {
                return productEntity;
            }
        }
        throw new RuntimeException("not found");
    }



}
