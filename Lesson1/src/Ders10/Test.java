package Ders10;

import java.util.Objects;

public class Test {
    int num;

    @Override
    public boolean equals(Object o) {
        if (this == o){
            System.out.println("equal");
            return true;
        }
        if (o == null || getClass() != o.getClass()) return false;
        Test test = (Test) o;
        System.out.println("num equals");
        return num == test.num;
    }

    @Override
    public int hashCode() {
        return Objects.hash(num);
    }
}
