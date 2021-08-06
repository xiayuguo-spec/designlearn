package com.example;

public class BuildMod {
    public BuildMod() {
    }

    public static void main(String[] args) {
//        BuildProduct product = new BuildProduct();
//        product.setPart1("111");
//        product.setPart2("222");
//        .....

        new BuildProduct.Builder().part1("1").part2("2").build();
    }
}

class BuildProduct{
    private String part1;
    private String part2;
    private String part3;
    private String part4;

    private BuildProduct(Builder builder) {
        part1 = builder.part1;
        part2 = builder.part2;
        part3 = builder.part3;
        part4 = builder.part4;
    }


    public static final class Builder {
        private String part1;
        private String part2;
        private String part3;
        private String part4;

        public Builder() {
        }

        public Builder part1(String val) {
            part1 = val;
            return this;
        }

        public Builder part2(String val) {
            part2 = val;
            return this;
        }

        public Builder part3(String val) {
            part3 = val;
            return this;
        }

        public Builder part4(String val) {
            part4 = val;
            return this;
        }

        public BuildProduct build() {
            return new BuildProduct(this);
        }
    }
}
