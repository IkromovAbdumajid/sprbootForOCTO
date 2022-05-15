package com.company.domi.controller;

import com.company.domi.dto.product.ProductDTO;
import com.company.domi.entity.ProductEntity;
import com.company.domi.enums.ProductType;
import com.company.domi.repository.ProductRepository;
import com.company.domi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    private ProductService productService;

    @PostMapping(value = "/create")
    public ResponseEntity<?> create(@RequestBody ProductDTO dto) {
        ProductDTO response = productService.create(dto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/buyProduct/{id}/{location}/{phone}")
    public ResponseEntity<?> create(@Valid @RequestBody Integer id, @PathVariable("location") String location, @PathVariable("phone") String phone) {
        productService.buyProduct(id, location, phone);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/update")
    public String update(@Valid @RequestBody ProductDTO dto) {
        productService.update(dto);
        return "redirect:/templates/index";
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Integer id) {
        productService.delete(id);
    }

    @RequestMapping("/TV")
    public String televizor(Model model,Model model1) {
        Integer countAll=productRepository.countAll(ProductType.Televizorlar);
        model1.addAttribute("hamma",countAll);
        List<String> creators=productRepository.allCreators(ProductType.Televizorlar);
        List<ProductEntity> productEntity=productRepository.findAllByProductType();
        model.addAttribute("product", productEntity);
        System.out.println(creators);
        model.addAttribute("creators",creators);
        return "tele";
    }

    @GetMapping("/phone")
    public String smartfon(Model model) {
        model.addAttribute("list", productService.get1());
        return "catalog/phone";
    }

    @GetMapping("/Kir_yuvish_mashinalari")
    public String Kir_yuvish_mashinalari(Model model) {
        model.addAttribute("list", productService.get2());
        return "catalog/phone";
    }

    @GetMapping("/Muzlatkichlar")
    public String muzlatkich(Model model) {
        model.addAttribute("list", productService.get3());
        return "pages/catalog/muzlatkichlar";
    }

    @GetMapping("/Telefonlar_va_gadjetlar")
    public String Telefonlar_va_gadjetlar(Model model) {
        model.addAttribute("list", productService.get4());
        return "pages/catalog/Telefonlar_va_gadjetlar";
    }

    @RequestMapping("/getProduct/Yirik_maishiy_texnika")
    public String Yirik_maishiy_texnika(Model model) {
        model.addAttribute("list", productService.get5());
        return "templates/index";
    }

    @RequestMapping("/getProduct/Kichik_maishiy_texnika")
    public String Kichik_maishiy_texnika(Model model) {
        model.addAttribute("list", productService.get6());
        return "templates/index";
    }

    @RequestMapping("/getProduct/Klimat_uskunalari")
    public String Klimat_uskunalari(Model model) {
        model.addAttribute("list", productService.get7());
        return "templates/index";
    }

    @RequestMapping("/getProduct/Tikuv_mashinalari")
    public String Tikuv_mashinalari(Model model) {
        model.addAttribute("list", productService.get8());
        return "templates/index";
    }


    @RequestMapping("/getById/{id}")
    public ResponseEntity<?> getProfileById(@Valid @PathVariable("id") Integer id) {
        ProductEntity response = productService.get(id);
        return ResponseEntity.ok(response);
    }

    @RequestMapping("/getByName")
    public String getByName(Model model,Model model1) {
        Integer countAll=productRepository.countAll(ProductType.Televizorlar);
        model1.addAttribute("hamma",countAll);
        ProductEntity productDTO=productService.findbyName();
        model.addAttribute("product",productDTO);
        return "tele";
    }

    @RequestMapping("/getByDescription/{description}")
    public ResponseEntity<?> getByDescription(@Valid @PathVariable("description") String description) {
        ProductEntity response = productService.findByDescription(description);
        return ResponseEntity.ok(response);
    }

    @RequestMapping("/getByType/{type}")
    public ResponseEntity<?> getByType(@PathVariable("type") ProductType productType) {
        ProductEntity response = productService.findByType(productType);
        return ResponseEntity.ok(response);
    }

    @RequestMapping("/fromPrice")
    public String getFromPrice(Integer min_p,Model model) {
        List<String> creators=productRepository.allCreators(ProductType.Televizorlar);
        List<ProductEntity> fromPrice=productRepository.fromPrice(min_p,ProductType.Televizorlar);
        model.addAttribute("product",fromPrice);
        model.addAttribute("creators",creators);
        return "tele";
    }

    @GetMapping("/toPrice")
    public String getByPrices(Integer to_p,Model model) {
        List<String> creators=productRepository.allCreators(ProductType.Televizorlar);
        List<ProductEntity> toPrice=productRepository.toPrice(to_p,ProductType.Televizorlar);
        model.addAttribute("product",toPrice);
        model.addAttribute("creators",creators);

        return "tele";
    }

    @GetMapping("/listCreator")
    public ResponseEntity<List<String>> getListCreators(Model model) {
        List<String> creators=productRepository.allCreators(ProductType.Televizorlar);
        model.addAttribute("creators",creators);

        model.addAttribute("list",productRepository.listCreator());
        return ResponseEntity.ok(productRepository.listCreator());
    }

    @GetMapping("/listOperSystem")
    public String getListOperSystem(Model model) {
        List<String> creators=productRepository.allCreators(ProductType.Televizorlar);
        model.addAttribute("creators",creators);

        model.addAttribute("operSystem",productRepository.listOperSystem());
        return "tele";
    }

    @GetMapping("/avvalArzonlari")
    public String getAvvalQimmatlari(Model model,Model model1) {
        List<String> creators=productRepository.allCreators(ProductType.Televizorlar);
        model.addAttribute("creators",creators);

        Integer countAll=productRepository.countAll(ProductType.Televizorlar);
        model1.addAttribute("hamma",countAll);
        List<ProductEntity> productDTO=productRepository.avvalArzonlari(ProductType.Televizorlar);
        model.addAttribute("product",productDTO);
        return "tele";
    }

    @GetMapping("/avvalQimmatlari")
    public String getAvvalArzonlari(Model model,Model model1) {
        List<String> creators=productRepository.allCreators(ProductType.Televizorlar);
        model.addAttribute("creators",creators);

        Integer countAll=productRepository.countAll(ProductType.Televizorlar);
        model1.addAttribute("hamma",countAll);
        List<ProductEntity> productDTO=productRepository.avvalQimmatlari(ProductType.Televizorlar);
        model.addAttribute("product",productDTO);
        return "tele";
    }

}
