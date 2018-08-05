package com.lgh.havehui.allpackage.bean;

import java.util.List;

/**
 * 作者 : 李观鸿
 * Created by MyPC on 2017/12/26.
 */

public class HomeModuleBean {

        private MenuBean           menu;
        private AdverstisementBean adverstisement;
        private ModuleBean         module;

        public MenuBean getMenu() {
            return menu;
        }

        public void setMenu(MenuBean menu) {
            this.menu = menu;
        }

        public AdverstisementBean getAdverstisement() {
            return adverstisement;
        }

        public void setAdverstisement(AdverstisementBean adverstisement) {
            this.adverstisement = adverstisement;
        }

        public ModuleBean getModule() {
            return module;
        }

        public void setModule(ModuleBean module) {
            this.module = module;
        }

        public static class MenuBean {
            private List<ListBean> list;

            public List<ListBean> getList() {
                return list;
            }

            public void setList(List<ListBean> list) {
                this.list = list;
            }

            public static class ListBean {
                private int    id;
                private int    type;
                private String menu_name;
                private int    menu_link_type;
                private String menu_pic;
                private String menu_link_id;
                private String menu_link;
                private int    menu_sort;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getType() {
                    return type;
                }

                public void setType(int type) {
                    this.type = type;
                }

                public String getMenu_name() {
                    return menu_name;
                }

                public void setMenu_name(String menu_name) {
                    this.menu_name = menu_name;
                }

                public int getMenu_link_type() {
                    return menu_link_type;
                }

                public void setMenu_link_type(int menu_link_type) {
                    this.menu_link_type = menu_link_type;
                }

                public String getMenu_pic() {
                    return menu_pic;
                }

                public void setMenu_pic(String menu_pic) {
                    this.menu_pic = menu_pic;
                }

                public String getMenu_link_id() {
                    return menu_link_id;
                }

                public void setMenu_link_id(String menu_link_id) {
                    this.menu_link_id = menu_link_id;
                }

                public String getMenu_link() {
                    return menu_link;
                }

                public void setMenu_link(String menu_link) {
                    this.menu_link = menu_link;
                }

                public int getMenu_sort() {
                    return menu_sort;
                }

                public void setMenu_sort(int menu_sort) {
                    this.menu_sort = menu_sort;
                }
            }
        }

        public static class AdverstisementBean {
            private List<?> list;

            public List<?> getList() {
                return list;
            }

            public void setList(List<?> list) {
                this.list = list;
            }
        }

        public static class ModuleBean {
            private List<ListBeanX> list;

            public List<ListBeanX> getList() {
                return list;
            }

            public void setList(List<ListBeanX> list) {
                this.list = list;
            }

            public static class ListBeanX {
                private int    id;
                private int    type;
                private String model_name;
                private String model_pic;
                private int    model_link_type;
                private int    model_link_id;
                private String model_link;
                private int    model_sort;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getType() {
                    return type;
                }

                public void setType(int type) {
                    this.type = type;
                }

                public String getModel_name() {
                    return model_name;
                }

                public void setModel_name(String model_name) {
                    this.model_name = model_name;
                }

                public String getModel_pic() {
                    return model_pic;
                }

                public void setModel_pic(String model_pic) {
                    this.model_pic = model_pic;
                }

                public int getModel_link_type() {
                    return model_link_type;
                }

                public void setModel_link_type(int model_link_type) {
                    this.model_link_type = model_link_type;
                }

                public int getModel_link_id() {
                    return model_link_id;
                }

                public void setModel_link_id(int model_link_id) {
                    this.model_link_id = model_link_id;
                }

                public String getModel_link() {
                    return model_link;
                }

                public void setModel_link(String model_link) {
                    this.model_link = model_link;
                }

                public int getModel_sort() {
                    return model_sort;
                }

                public void setModel_sort(int model_sort) {
                    this.model_sort = model_sort;
                }
            }
        }

}
