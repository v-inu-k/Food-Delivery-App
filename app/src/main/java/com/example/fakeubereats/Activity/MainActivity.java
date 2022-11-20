package com.example.fakeubereats.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.fakeubereats.DB.DBHelper;
import com.example.fakeubereats.DB.DBModel;
import com.example.fakeubereats.DB.InsertData;
import com.example.fakeubereats.Fragments.AccountFragment;
import com.example.fakeubereats.Fragments.BasketFragment;
import com.example.fakeubereats.Fragments.BrowseFragment;
import com.example.fakeubereats.R;
import com.example.fakeubereats.Fragments.RestaurantsFragment;
import com.example.fakeubereats.model.Item;
import com.example.fakeubereats.model.Order;
import com.example.fakeubereats.model.Restaurant;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    public static String username;
    public static ArrayList<Order> orderList = new ArrayList<>();
    public static ArrayList<Item> itemList = new ArrayList<>();
    BottomNavigationView NavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ;
        NavigationView = findViewById(R.id.BottomNavigationView);
        getSupportFragmentManager().beginTransaction().replace(R.id.body_container, new BrowseFragment()).commit();
        NavigationView.setSelectedItemId(R.id.nav_Browse);

        NavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;
                switch (item.getItemId()) {
                    case R.id.nav_Browse:
                        selectedFragment = new BrowseFragment();
                        break;
                    case R.id.nav_restaurant:
                        selectedFragment = new RestaurantsFragment();
                        break;
                    case R.id.nav_Basket:
                        selectedFragment = new BasketFragment();
                        break;
                    case R.id.nav_Account:
                        selectedFragment = new AccountFragment();
                        break;

                }
                getSupportFragmentManager().beginTransaction().replace(R.id.body_container, selectedFragment).commit();
                return true;
            }
        });

        }
        //Create a class to add restaurants to the database
        public void addRestaurant(int restaurantID, String name, String address, Double rating, int LogoRef) {
            DBHelper dbHelper = new DBHelper(this);
            dbHelper.addRestaurant(restaurantID, name, address, rating, LogoRef);
        }
        /*public void initFood() {
        addFood(1, 1, "Whopper", 1650, "A ¼ lb* of flame-grilled beef patty topped with juicy tomatoes, crisp lettuce, creamy mayonnaise, ketchup, crunchy pickles, and sliced white onions on a toasted sesame seed bun.", "BK_Whooper.png");
        addFood(2,1,"Bacon King", 2100, "Two 1/4 lb* flame-grilled beef patties with crispy bacon, melted American cheese, ketchup, and creamy mayonnaise on a toasted sesame seed bun.", "BK_BaconKing.jpg");
        addFood(3,1,"Double Cheeseburger", 1800,"Two flame-grilled patties–for a 1/4 lb* of beef–with melted American cheese, crunchy pickles, yellow mustard, and ketchup on a toasted sesame seed bun.", "BK_DoubleCheeseburger.png");
        addFood(4,1,"Rodeo Burger", 1450, "A flame-grilled beef patty with sweet and smoky BBQ sauce and crispy onion rings on a toasted sesame seed bun.", "BK_RodeoBurger.jpg");
        addFood(5,1,"Chicken Royale", 1450, "A crispy chicken fillet topped with melted Swiss cheese, creamy mayonnaise, crisp lettuce, juicy tomatoes, and sliced white onions on a toasted sesame seed bun.", "BK_ChickenRoyale.png");
        addFood(6,1,"Chicken Nuggets", 750, "A crispy chicken fillet", "BK_ChickenNuggets.jpg");

        addFood(7,2, "Cheesy Double Decker Taco", 950,"Guaranteed to change the way you think about tacos as you know them. It’s got the best of both worlds with a grilled flatbread covered with melted two-cheese blend and wrapped around a crunchy taco with your choice of protein, zesty ranch, crisp lettuce and cheese.", "TacoBell_CheesyDoubleDeckerTaco.png");
        addFood(8,2, "Grilled Stuft Burrito", 950,"Filled with a huge arsenal of your choice of protein, chipotle mayo, two-cheese blend, Mexican seasoned rice, black beans and fiesta salsa, wrapped inside a warm toasted tortilla!", "TacoBell_GrilledStuftBurrito.png");
        addFood(9,2,"Crunchwrap Supreme", 950,"Your choice of protein, nacho cheese sauce, crunchy tostada, sour cream, lettuce and tomato inside a warm toasted tortilla in our signature six-sided wrap!", "TacoBell_CrunchwrapSupreme.png");
        addFood(10,2,"Crunchy Taco", 900, "Our crunchy taco shells, introduced into the world by our founder Glen Bell in 1962, are cooked fresh daily with love and filled with only the freshest ingredients. Including seasoned beef, shredded cheese and lettuce.", "TacoBell_CrunchyTaco.png");
        addFood(11,2,"Beefy Cheesy Burrito", 1200, "The perfect snack on the go filled with Mexican seasoned rice, nacho cheese sauce and seasoned beef.", "TacoBell_BeefyCheesyBurrito.png");
        addFood(12,2,"Mini Chicken Quesadilla", 950, "Grilled soft tortilla filled with melted cheese and freshly prepared chicken. Delicious without the bells and whistles!!", "TacoBell_MiniChickenQuesadilla.png");

        addFood(13, 3, "Double Chicken Surprise", 2790, "A combination of devilled chicken and succulent chicken sausages accompanied with crunchy onions and capsicum, topped with a layer of mozzarella cheese", "PizzaHut_DoubleChickenSurprise.jpg");
        addFood(14, 3, "Tandoori Chicken", 2790, "Tandoori chicken & onions with a double layer of cheese.", "PizzaHut_TandooriChicken.jpg");
        addFood(15,3, "Butter Chicken Masala",3080, "The ever famous Butter Masala Chicken together with a layer of cream cheese, fresh onions, coriander, ginger and garlic, blanketed with a layer of mozzarella cheese.", "PizzaHut_ButterChickenMasala.jpg");
        addFood(16, 3, "Meat Lovers - Beef", 3710,"Beef pepperoni and chicken sausage with a double layer of cheese.", "PizzaHut_MeatLoversBeef.jpg");
        addFood(17,3,"Hot & Spicy Chicken", 3100, "Spicy chunks of chicken, capsicums & onions with a double layer of cheese.", "PizzaHut_HotAndSpicyChicken.jpg");
        addFood(18,3,"Double Chicken & Cheese Fiesta", 2790, "A combination of spicy chicken and chicken sausages with crunchy onions and jalapenos placed on a layer of cream cheese and a layer of mozzarella.", "PizzaHut_DoubleChickenAndCheeseFiesta.jpg");

        addFood(19,4,"Peri Peri Chicken Pizza", 1990, "A flavoursome pairing of seasoned chicken pieces, Italian cherry tomatoes, sliced red onion & baby spinach, topped with our addictive peri peri sauce", "Dominos_PeriPeriChickenPizza.jpg");
        addFood(20,4,"Loaded Supreme", 2100, "Ground beef, crispy rasher bacon, mushroom, pepperoni, Italian sausage, fresh baby spinach, smoked leg ham, pineapple, topped with oregano, tomato capsicum sauce & spring onion.", "Dominos_LoadedSupreme.jpg");
        addFood(21,4,"Garlic Prawn", 1600, "Juicy prawns with fresh baby spinach & diced tomato on a crème fraiche & zesty garlic sauce base, topped with oregano", "Dominos_GarlicPrawn.jpg");
        addFood(22,4,"Hawaiian", 2400, "A classic pairing of smoky leg ham & sweet pineapple pieces", "Dominos_Hawaiian.jpg");
        addFood(23,4,"Godfather", 2900, "Domino's pepperoni paired with Italian sausage, fresh capsicum, diced tomato & Kalamata olives on a zesty garlic & pizza sauce base, topped with oregano", "Dominos_Godfather.jpg");
        addFood(24,4,"Margherita", 1200, "Diced tomatoes & stretchy mozzarella, topped with oregano", "Dominos_Margherita.jpg");

        addFood(25,5,"Spicy Chicken Sandwich", 2400, "One piece of Spicy chicken tender in between two buttered buns", "Popeyes_SpicyChickenSandwich.jpg");
        addFood(26,5,"Classic Chicken Sandwich", 2200, "One piece of classic chicken tender in between two buttered buns.", "Popeyes_ClassicChickenSandwich.jpg");
        addFood(27,5,"Hushpuppy Shrimp", 1800, "8Pcs of Deep Fried and seasoned Shrimp", "Popeyes_HushpuppyShrimp.jpg");

        addFood(28,6,"Zinger Burger", 2200, "One piece of Zinger chicken tender in between two buttered buns.", "KFC_ZingerBurger.png");
        addFood(29,6, "Snacker", 650, "Small piece of chicken with fries and a drink", "KFC_Snacker.png");
        addFood(30,6,"Double Decker Burger", 2800, "Two pieces of Zinger chicken tender in between two buttered buns.", "KFC_DoubleDeckerBurger.png");


    }*/
        public void initRestaurant() {
        addRestaurant(1, "Burger King", "385 Main St, Negombo", 4.0, R.drawable.bk);
        addRestaurant(2, "Taco Bell", "319 Negombo-Colombo Main Rd, Negombo",  4.4, R.drawable.tacobell);
        addRestaurant(3, "Pizza Hut", "St Philip Neris Ave, Negombo Rd, Colombo",  4.1, R.drawable.pizzahut);
        addRestaurant(4, "Domino's Pizza", " No.163 Negombo-Colombo Main Rd, Negombo 11500",  4.2, R.drawable.dominos);
        addRestaurant(5, "Popeye's", "Dehiwala-Mount Lavinia",  4.1, R.drawable.popeyes);
        addRestaurant(6, "KFC", "St Michaels Rd, Colombo",  3.8, R.drawable.kfc);
        }


    }