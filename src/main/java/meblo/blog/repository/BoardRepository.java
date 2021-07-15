package meblo.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import meblo.blog.model.Board;

public interface BoardRepository extends JpaRepository<Board, Integer> {

	@Modifying
	@Query("update Board b set b.count = b.count + 1 where b.idx = : idx")
	int updateCount(int idx);

}
