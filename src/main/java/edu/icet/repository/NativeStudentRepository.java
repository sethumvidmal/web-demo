package edu.icet.repository;

import java.util.List;

public interface NativeStudentRepository {
    public Integer retrieveStudentCount();

    public List<String> retrieveFirstNameById(String id);
}
