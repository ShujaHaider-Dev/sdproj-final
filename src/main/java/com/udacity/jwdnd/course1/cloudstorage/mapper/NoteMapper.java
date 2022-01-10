package com.udacity.jwdnd.course1.cloudstorage.mapper;

import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface NoteMapper {

    @Select("SELECT * FROM NOTES WHERE userid = #{userId}")
    List<Note> findAllNotesByUserId(Integer userId);

    @Select("SELECT * FROM NOTES WHERE noteid = #{id}")
    Note findNoteById(Integer id);

    @Select("SELECT * FROM NOTES WHERE notetitle = #{title} AND notedescription = #{description}")
    Note findNoteByTitleAndDescription(String title, String description);

    @Insert("INSERT INTO NOTES (notetitle, notedescription, userid) " +
            "VALUES(#{title}, #{description}, #{userId})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void save(Note note);

    @Update("UPDATE NOTES SET notetitle = #{title}, notedescription = #{description} WHERE noteid = #{id} AND userId = #{userId}")
    void update(Integer id, String title, String description, Integer userId);

    @Delete("DELETE FROM NOTES WHERE noteid = #{id} AND userId = #{userId}")
    void delete(Integer id, Integer userId);
}