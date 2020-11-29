package com.edoup.base.comparable;

/**
 * <p></p>
 *
 * @author edoup
 * @date 2020/8/11 0:50
 */
public class Book implements Comparable<Book> {

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int compareTo(Book o) {
        if (this.id > o.getId()) {
            return 1;
        } else if (this.id < o.getId()) {
            return -1;
        } else {
            return 0;
        }
    }

    
}
