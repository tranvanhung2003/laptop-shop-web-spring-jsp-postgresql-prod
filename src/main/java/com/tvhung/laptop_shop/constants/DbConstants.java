package com.tvhung.laptop_shop.constants;

public final class DbConstants {
    private DbConstants() {
    }

    public static final class UserTable {
        private UserTable() {
        }

        public static final String TABLE_NAME = "users";
        public static final String MAPPED_BY = "user";

        public static final String ROLE_ID = "role_id";
    }

    public static final class RoleTable {
        private RoleTable() {
        }

        public static final String TABLE_NAME = "roles";
        public static final String MAPPED_BY = "role";
    }

    public static final class ProductTable {
        private ProductTable() {
        }

        public static final String TABLE_NAME = "products";
        public static final String MAPPED_BY = "product";
    }

    public static final class OrderTable {
        private OrderTable() {
        }

        public static final String TABLE_NAME = "orders";
        public static final String MAPPED_BY = "order";

        public static final String USER_ID = "user_id";
    }

    public static final class OrderDetailTable {
        private OrderDetailTable() {
        }

        public static final String TABLE_NAME = "order_details";
        public static final String MAPPED_BY = "orderDetail";

        public static final String ORDER_ID = "order_id";
        public static final String PRODUCT_ID = "product_id";
    }
}
