package com.company.domi.repository;

import com.company.domi.entity.ProductEntity;
import com.company.domi.enums.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
    List<ProductEntity> findByCount(Integer count);

    @Query(value = "select p from ProductEntity p where p.productType='Televizorlar'")
    List<ProductEntity> findAllByProductType();

    @Query("select p from ProductEntity p where p.productType='Smartfonlar'")
    ProductEntity findAllByProductType1();

    @Query("select p from ProductEntity p where p.productType='Kir_yuvish_mashinalari'")
    ProductEntity findAllByProductType2();

    @Query("select p from ProductEntity p where p.productType='Muzlatkichlar'")
    ProductEntity findAllByProductType3();

    @Query("select p from ProductEntity p where p.productType='Telefonlar_va_gadjetlar'")
    ProductEntity findAllByProductType4();

    @Query("select p from ProductEntity p where p.productType='Yirik_maishiy_texnika'")
    ProductEntity findAllByProductType6();

    @Query("select p from ProductEntity p where p.productType='Kichik_maishiy_texnika'")
    ProductEntity findAllByProductType7();

    @Query("select p from ProductEntity p where p.productType='Klimat_uskunalari'")
    ProductEntity findAllByProductType8();

    @Query("select p from ProductEntity p where p.productType='Tikuv_mashinalari'")
    ProductEntity findAllByProductType9();

    @Query("select p from ProductEntity p where p.productType='Ornatiluvchi_texnika'")
    ProductEntity findAllByProductType10();

    @Query("select p from ProductEntity p where p.productType='Oshxona_texnikasi'")
    ProductEntity findAllByProductType11();

    @Query("select p from ProductEntity p where p.productType='Sportga_oid_mahsulotlar'")
    ProductEntity findAllByProductType12();

    @Query("select p from ProductEntity p where p.productType='Printerlar_va_skanerlar'")
    ProductEntity findAllByProductType13();

    @Query("select p from ProductEntity p where p.productType='Uy_va_ishxona_jixozlari'")
    ProductEntity findAllByProductType14();


    @Query("select p from ProductEntity p where p.name=?1")
    ProductEntity searchAllByName(String object);


    List<ProductEntity> findByName(String name);

    List<ProductEntity> findByPrice(Long price);

    List<ProductEntity> findByDescription(String description);

    List<ProductEntity> findAllByProductType(ProductType productType);


    //Smartfon
    @Query("select p from ProductEntity p where p.price>?1 and p.productType=?2")
    List<ProductEntity> fromPrice(Integer price,ProductType productType);

    @Query("select p from ProductEntity p  where p.price<?1 and p.productType=?2")
    List<ProductEntity> toPrice(Integer price,ProductType productType);

    @Query("select distinct p.creator from ProductEntity p")
    List<String> listCreator();

    @Query("select distinct p.operSystem from ProductEntity p")
    List<String> listOperSystem();

    @Query("select p from ProductEntity p where p.productType =?1 order by p.price desc")
    List<ProductEntity> avvalQimmatlari(ProductType type);

    @Query("select p from ProductEntity p where p.productType =?1 order by p.price asc")
    List<ProductEntity> avvalArzonlari(ProductType type);

    @Query("select count(p) from ProductEntity p where p.productType =?1")
    Integer countAll(ProductType type);

    @Query("select p from ProductEntity p  where p.productType =?1 order by p.name asc")
    List<ProductEntity> orderByName(ProductType type);

    @Query("select p.creator from ProductEntity p where p.productType=?1")
    List<String> allCreators(ProductType productType);

    @Query("select p.creator from ProductEntity p where p.operSystem=?1")
    List<String> allOperSysteam(ProductType productType);
}
