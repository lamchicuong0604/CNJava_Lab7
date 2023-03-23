package com.example.demo.repository;
import java.util.List;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.Student;
@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {
	List<Student> findByAgeGreaterThanEqual(int age);
    
    int countByIeltsScore(double d);
    
    List<Student> findByNameContainingIgnoreCase(String name);
    
    
    //----------------------------------EX5---------------------------------------------------
//    @Query("SELECT s FROM Student s WHERE s.age >= :x")
//    List<Student> findByAgeGreaterThanOrEqual(@Param("x") int x);
//
//    @Query("SELECT COUNT(s) FROM Student s WHERE s.ieltsScore = :x")
//    long countByIeltsScore(@Param("x") double d);
//
//    @Query("SELECT s FROM students s WHERE LOWER(s.name) LIKE CONCAT('%', LOWER(:xxx), '%')")
//   List<Student> findByNameContainingIgnoreCase(@Param("xxx") String xxx);

}
