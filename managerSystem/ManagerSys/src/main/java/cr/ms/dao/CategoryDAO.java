package cr.ms.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cr.ms.pojo.Category;

public interface CategoryDAO extends JpaRepository<Category, Integer> {

}
