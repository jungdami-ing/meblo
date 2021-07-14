package meblo.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import meblo.blog.model.Board;

public interface BoardRepository extends JpaRepository<Board, Integer> {

}
