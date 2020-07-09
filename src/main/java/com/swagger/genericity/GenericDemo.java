package com.swagger.genericity;

/**
 * https://blog.csdn.net/aa1215018028/article/details/84882086
 *
 * @author zzhu8
 */
public class GenericDemo {

    /**
     * 泛型约束传入的对象必须实现Comparable接口
     * @param arr
     * @param <T>
     * @return
     */
    private static <T extends Comparable> T compare(T arr[]){
        T max = arr[0];
        for (T t : arr) {
            if (t.compareTo(max) > 0) {
                max = t;
            }
        }
        return max;
    }

    static class A implements Comparable<A> {

        private String name;
        private Integer age;

        @Override
        public String toString() {
            return "A{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public A(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public int compareTo(A o) {
            return age - o.getAge();
        }
    }

    public static void main(String[] args) {
        A a = new A("zhu",21);
        A b = new A("zhu",22);
        A c = new A("zhu",29);
        A[] arr = new A[]{a,b,c};
        System.out.println(GenericDemo.compare(arr));
    }


}
