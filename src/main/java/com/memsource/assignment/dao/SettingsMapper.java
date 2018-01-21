package com.memsource.assignment.dao;

import com.memsource.assignment.model.Settings;
import org.apache.ibatis.annotations.*;

/**
 * DAO class for settings object.
 */
@Mapper
public interface SettingsMapper {

    /**
     * Fetch settings with defined ID.
     * @param id searched id
     * @return settings with specific id or null
     */
    @Select("SELECT id, user, password FROM settings WHERE id = #{id}")
    Settings fetch(@Param("id") int id);

    /**
     * Insert new settings.
     * @param settings new settings object
     * @return number of created rows
     */
    @Insert("INSERT INTO settings(id, user, password) VALUES (#{id}, #{user}, #{password})")
    int insert(Settings settings);

    /**
     * Update existed settings.
     * @param settings settings to persist
     * @return number of updated rows
     */
    @Update("update settings set user=#{user}, password=#{password} where id=#{id}")
    int update(Settings settings);

    /**
     * Delete settings with specified id.
     * @param settings settings object to delete
     * @return number of deleted rows
     */
    @Delete("delete from settings where id=#{id}")
    int delete(Settings settings);
}
