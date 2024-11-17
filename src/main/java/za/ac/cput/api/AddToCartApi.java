package za.ac.cput.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.cput.domain.Cart;
import za.ac.cput.domain.Product;
import za.ac.cput.service.cartService.CartService;
import za.ac.cput.service.productService.ProductService;

import java.time.LocalDate;

@Component
public class AddToCartApi {
    private final ProductService productService;
    private final CartService cartService;

    @Autowired
    public AddToCartApi(CartService cartService, ProductService productService) {
        this.cartService = cartService;
        this.productService = productService;
    }

    public Cart addProductToCart(Long cartId, Long productId) {
        // Retrieve the cart and product
        Cart cart = cartService.read(cartId);
        System.out.println("Before adding to cart operation: " + cart);

        Product product = productService.read(productId);
        System.out.println("Before adding to cart operation: " + product);

        if (cart != null && product != null) {
            boolean updated = false;

            for (Product cartProduct : cart.getCartProducts()) {
                if (cartProduct.getProductId() == (productId)) {
                    Product updatedProduct = new Product.Builder()
                            .copy(cartProduct)
                            .setPrice(product.getPrice() + cartProduct.getPrice())
                            .build();

                    cart.getCartProducts().remove(cartProduct);
                    cart.getCartProducts().add(updatedProduct);
                    updated = true;
                    break;
                }
            }

            if (!updated) {
                // Product not found in the cart, add a new entry with quantity 1
                Product newProduct = new Product.Builder()
                        .copy(product)
                        .setPrice(500)
                        .build();

                cart.getCartProducts().add(newProduct);
                System.out.println("Product not found, added to cart");
                System.out.println(cart);
            }

            // Create a new Cart instance with updated date
            Cart updatedCart = new Cart.Builder()
                    .copy(cart)
                    .setUpdatedDate(LocalDate.now())
                    .build();

            return cartService.update(updatedCart);
        }

        return null;
}
}
