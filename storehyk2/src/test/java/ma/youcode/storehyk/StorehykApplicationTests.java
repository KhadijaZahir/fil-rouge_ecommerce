package ma.youcode.storehyk;

import ch.qos.logback.core.net.SyslogOutputStream;
import ma.youcode.storehyk.model.Category;
import ma.youcode.storehyk.model.Product;
import ma.youcode.storehyk.model.Role;
import ma.youcode.storehyk.model.User;
import ma.youcode.storehyk.repository.CategoryRepository;
import ma.youcode.storehyk.repository.ProductRepository;
import ma.youcode.storehyk.repository.RoleRepository;
import ma.youcode.storehyk.repository.UserRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class StorehykApplicationTests {
    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    UserRepository userRepository;

    //TestCategory
/* @Test
    public void testCategory() {
      //start init data
        Category category = new Category();
        category.setName("newCategory");
      // end init data

       //getAllCategory()
        List<Category> list = categoryRepository.findAll();
        System.out.println(list.isEmpty());
        System.out.println("category list :  "+list);
        //updateCategory() <for create>
        category = categoryRepository.save(category);
        System.out.println("category added :  "+ category);
        //updateCategory() <for update>
        category.setName("updateNewCategory");
        category = categoryRepository.save(category);
        System.out.println("category updated :  "+ category);
        //getCategoryById()
        Optional<Category> optionalCategory = categoryRepository.findById(category.getId());
        category = optionalCategory.get();
        System.out.println("category id :  "+ optionalCategory);

        //removeCategoryById()
       categoryRepository.deleteById(category.getId());
       categoryRepository.deleteById(14);

  }*/

    //TestProduct
/*@Test
    public void testProduct() {
      //start init data
        Product product = new Product();
        product.setDescription("newDescription");
        product.setImageName("newImageName");
        product.setName("newProduct");
        product.setPrice(200d);
        product.setWeight(0.2d);
        //getCategoryById and set
        product.setCategory(categoryRepository.findById(1).get());
      // end init data

        //getAllProduct
        List<Product> list = productRepository.findAll();
        System.out.println(list.isEmpty());
        System.out.println("***** product  list :  "+list);
        //updateProduct() <for create>
        product = productRepository.save(product);
        System.out.println("***** product  added :  "+product);
        //updateProduct() <for update>
        product.setName("updateProduct");
        product = productRepository.save(product);
        System.out.println("***** product  updated :  "+product);

        //getProductById()
        Optional<Product> optionalProduct = productRepository.findById(product.getId());
        product = optionalProduct.get();
        System.out.println("***** product  id :  "+product);

        //removeProductById()
//      productRepository.deleteById(product.getId());
//     productRepository.deleteById(10L);
//    productRepository.deleteById(11L);



    //get All Product By CategoryId
        List<Product> listByCategory = productRepository.findAllByCategory_Id(6);
        System.out.println("***** listByCategory :  "+listByCategory);
    }*/

    //Test User
/*@Test
    public void testUser() {
        //start init data
        User user = new User();
        user.setEmail("testser@gmail.com");
        user.setPassword(bCryptPasswordEncoder.encode("1"));
        user.setFirstName("jjf");
        user.setLastName("fjj");
        List<Role> roles = new ArrayList<>();
        roles.add(roleRepository.findById(1).get());
        roles.add(roleRepository.findById(2).get());
        //System.out.println("***** Roles  here :  "+roles);
        user.setRoles(roles);
        // end init data

        //getAllUser()
        List<User> list = userRepository.findAll();
        System.out.println(list.isEmpty());
        //System.out.println("***** user  list :  "+list);
        //updateUser() <for create>
        user = userRepository.save(user);
        //System.out.println("***** user  added :  "+user);
        //updateUser() <for update>
        user.setFirstName("fggf");
        user = userRepository.save(user);
        //System.out.println("***** user  updated :  "+user);
        //getUserById()
        Optional<User> opUser = userRepository.findById(user.getId());
        //System.out.println("***** user  added :  "+opUser);

        //removeUserById()
 userRepository.deleteById(user.getId());
 userRepository.deleteById(8);
//        userRepository.deleteById(9);
    }*/


    //Test login
  /* @Test
    public void testLogin() {
        List<User> list = userRepository.findAll();
        list.forEach(item -> {
            if (item.getEmail().equals("admin@gmail.com") && bCryptPasswordEncoder.matches("admin", item.getPassword())){
                System.out.println("login success");
            }else {
                System.out.println("login fail");
            }
        });
    }*/

    //Test Role
/*  @Test
  public void testRole() {
        //start init data
        Role role = new Role();
        //id 1-admin, 2-user
        // end init data

        //getAllRole()
        List<Role> list = roleRepository.findAll();
        System.out.println(list.isEmpty());
      // System.out.println("***** LIST role : list);

      //findRoleById()
        Optional<Role> optionalRole = roleRepository.findById(1);
        role = optionalRole.get();
      // System.out.println("***** role :  "+role);
  }*/




   /**************/
  /* @Test
    public void testGeProduct() throws ClassNotFoundException, SQLException {
       Product product = new Product();
       product = productRepository.getById(2L);

       System.out.println("name: " + product.getName());
       System.out.println("name: " + product.getName());
       List<Product> products = productRepository.findAll();
       System.out.println("name: " + products.get(0).getName());
       assertEquals("earring", products.get(0).getName());
       System.out.println("test1 ");
   }*/

/*===================================*/
   /* @Test
	@Rollback(false)
	public void testCreateProduct() {
		Product savedProduct = productRepository.save(new Product("newProduct", "categpry", "200", "0.2", "newDescription", "newImageName"));
		//assertThat(savedProduct.getId()).isGreaterThan(0);
        assertThat(savedProduct.getDescription()).isEqualTo("newDescription");
        System.out.println("product added");
	}*/
  /*@Test
   public void testDeleteProduct(){
       Category category= new Category();
       Product product = new Product("earring",category, 2, 22, "desc", "admin@gmail.com");
      //System.out.print(product);
      // System.out.print(product.getName());
      productRepository.save(product);

       Product prodt = productRepository.findByName("earrings");
      //assertNotNull(product);
      System.out.print(prodt.getName());
      System.out.print(product.getName());
      assertEquals(prodt.getName(), product.getName());

       //assertEquals(employee2.getName(), employee.getName());
       //assertEquals(productRepository.deleteByyId(2L), "supp");
   }*/
}
