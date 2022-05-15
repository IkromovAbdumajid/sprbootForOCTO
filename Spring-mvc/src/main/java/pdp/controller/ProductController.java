package pdp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pdp.dto.ApiResponse;
import pdp.entity.Product;
import pdp.repository.ProductRepository;
import pdp.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductService productService;

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public String getProductPage(Model model) {
        model.addAttribute("productList",
                productRepository.getProducts());
        return "product";
    }

    @RequestMapping(path = "/add", method = RequestMethod.GET)
    public String getAddPage() {
        return "product-add";
    }

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public String getSave(@ModelAttribute Product product) {
        //logika
        //bazaga saqlash kerak
        productService.save(product);
//        System.out.println("Zo'r!");
        return "redirect:/product/all";
    }


    //delete/1222
    @RequestMapping(path = "/delete/{model}", method = RequestMethod.GET)
    public String delete(@PathVariable String model) {
        System.out.println("Zo'r");
        ApiResponse response = productService.delete(model);
        System.out.println(response);
        return "redirect:/product/all";
    }

    @RequestMapping(path = "/edit/{model}", method = RequestMethod.GET)
    public String edit(@PathVariable String model, Model front) {
        ApiResponse edit = productService.edit(model);
        Product product = (Product) edit.getObject();
        front.addAttribute("product", product);
        return "product-add";
    }
}
