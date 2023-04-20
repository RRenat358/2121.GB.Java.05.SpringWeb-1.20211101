package ru.rrenat358.HWSpring;


import org.springframework.stereotype.Component;


@Component
public class ProductService01 {

    private static Integer id = 0;
    private String name = "noName";
    private Double price = 0.00;

    private final Product product;

    public ProductService01(String name, Double price, Product product) {
        this.name = name;
        this.price = price;
        this.product = product;
    }

    public static void initId(Integer id) {
//        product.setId(id++);
    }

    public void initName(Product product) {
        product.setName("Name:" + name);
    }

    public void initPrice(Product product) {
        product.setPrice(price);
    }


    public Product createNewProduct() {
        Product product = new Product();
//        order.setName("Заказ ещё и # "); //for manual Bean
//        initId(product);
        return product;

    }



//    Product product = new Product();

/*
    public List<Object> ListProductService(List<Object> list) {
        list.add(product.getId());
        list.add(product.getName());
        list.add(product.getPrice());

        return list;
    }
*/




}
