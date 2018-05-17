package com.sxt.dp;

public class Template {
    public static void main(String[] args) {
    ParentTemplateMethod ptm = new ParentTemplateMethod() {
        @Override
        public void mid() {
            System.out.println("Template.mid");
        }
    };
      ptm.templte();
    }
}
