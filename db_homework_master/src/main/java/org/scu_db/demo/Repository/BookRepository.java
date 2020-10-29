package org.scu_db.demo.Repository;

import org.scu_db.demo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    //继承于JpaRepository,其中Title为对应的实体类，String为实体类主键属性

    List<Book> findBooksByBookId(Integer bookId);

    @Query(value = "select * from book where book_id =?1", nativeQuery = true)
    List<Book> findBookByIdUseSql(Integer bookId);

    @Query(value="Select Book_ID from BooK where BorrowerMemNo IS NOT NULL",nativeQuery = true)
    List<Integer> findAllBorrowedBookId();

   // @Query(value="Select callnumber from book where group by callnumber having count(*)<=?1",nativeQuery = true)
    //List<String> findBooklessthan(Integer num);
}
