package com.company.domi.service;

import com.company.domi.dto.PurchasedProductsDTO;
import com.company.domi.entity.Attachment;
import com.company.domi.entity.AttachmentContent;
import com.company.domi.entity.ProductEntity;
import com.company.domi.entity.PurchasedProductsEntity;
import com.company.domi.repository.AttachmentContentRepository;
import com.company.domi.repository.AttachmentRepository;
import com.company.domi.repository.PurchasedProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchasedProductsService {
    @Autowired
    PurchasedProductsRepository purchasedProductsRepository;

    @Autowired
    AttachmentRepository attachmentRepository;

    @Autowired
    AttachmentContentRepository attachmentContentRepository;

    public PurchasedProductsDTO create(ProductEntity dto, String location, String phone) {
        PurchasedProductsEntity purchasedProductsEntity=new PurchasedProductsEntity();
        purchasedProductsEntity.setName(dto.getName());
        purchasedProductsEntity.setCount(1);
            Attachment attachment = new Attachment();
            attachment.setName(dto.getImage().getName());
            attachment.setSize(dto.getImage().getSize());
            attachment.setContent_type(dto.getImage().getContent_type());
            Attachment save = attachmentRepository.save(attachment);
            AttachmentContent attachmentContent = new AttachmentContent();
            attachmentContent.setAttachment(save);
            attachmentContentRepository.save(attachmentContent);
            purchasedProductsEntity.setImage(attachment);

        purchasedProductsEntity.setPrice(dto.getPrice());
        purchasedProductsEntity.setLocation(location);
        purchasedProductsEntity.setPhone(phone);
        purchasedProductsEntity.setOverall(purchasedProductsEntity.getCount()*dto.getPrice());

        PurchasedProductsDTO purchasedProductsDTO=new PurchasedProductsDTO();
        purchasedProductsRepository.save(purchasedProductsEntity);
        purchasedProductsDTO.setId(purchasedProductsEntity.getId());
        return purchasedProductsDTO;
    }

}
