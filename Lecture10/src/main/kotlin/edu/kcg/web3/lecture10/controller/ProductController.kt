package edu.kcg.web3.lecture10.controller

import edu.kcg.web3.lecture10.entity.Product
import edu.kcg.web3.lecture10.entity.ShopOrder
import edu.kcg.web3.lecture10.repository.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
@RequestMapping("/products")
class ProductController(
    @Autowired private val productRepository: ProductRepository
) {

    @RequestMapping
    fun showAllProducts(model: Model): String {
        model["title"] = "Products page"
        model["products"] = productRepository.findAll().sortedBy { it.id }
        return "products"
    }

    @PostMapping("/new")
    fun newProduct(model: Model, @RequestParam name: String, @RequestParam price: String): String {
        Product().apply {
            this.name = name
            this.price = price.toLongOrNull() ?: 0
            productRepository.save(this)
        }
        return showAllProducts(model)
    }

    @RequestMapping("/{id}/orders")
    fun productDetail(model: Model, @PathVariable id: String): String {
        model["title"] = "Product detail"
        model["orders"] = productRepository.findByIdOrNull(id.toLongOrNull())?.shopOrders ?: emptySet<ShopOrder>()
        return "products-orders"
    }

}
