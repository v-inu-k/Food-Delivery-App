package com.example.fakeubereats.DB;

public class DBSchema {
    public static final class UserTable {
        public static final String NAME = "User";

        public static final class Cols {
            public static final String EMAIL = "email";
            public static final String NAME = "name";
            public static final String PASSWORD = "password";
        }
    }

    public static final class RestaurantTable {
        public static final String NAME = "Restaurant";

        public static final class Cols {
            public static final String RESTAURANT_ID = "restaurantID";
            public static final String RESTAURANT_NAME = "restaurantName";
            public static final String RESTAURANT_LOGO = "restaurantLogoPath";
            public static final String RESTAURANT_RATING = "restaurantRating";
            public static final String RESTAURANT_ADDRESS = "restaurantAddress";
        }
    }

    public static final class OrderTable {
        public static final String NAME = "Orders";

        public static final class Cols {
            public static final String ORDER_ID = "orderID";
            public static final String USER_ID = "userID";
            public static final String FOOD_ITEM = "foodItem";
            public static final String RESTAURANT_ID = "restaurantID";
            public static final String UNIT_PRICE = "unitPrice";
            public static final String AMOUNT = "amount";
            public static final String TOTAL_PRICE = "totalPrice";
            public static final String DATE = "date";
        }
    }

    public static final class ItemTable {
        public static final String NAME = "FoodItem";


        public static final class Cols {
            public static final String FOOD_ID = "foodID";
            public static final String FOOD_NAME = "foodName";
            public static final String FOOD_PRICE = "foodPrice";
            public static final String FOOD_DESCRIPTION = "foodDesc";
            public static final String RESTAURANT_ID = "restaurantID";
            public static final String FOOD_IMAGE_PATH = "foodImagePath";
        }
    }
}

