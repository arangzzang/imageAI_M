//package com.freek.imageai_m.common.entity;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Table;
//import lombok.AccessLevel;
//import lombok.Builder;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import org.springframework.data.annotation.Id;
//
//@Entity
//@Table(name = "FileData")
//@Getter
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
//public class FileData {
//
//    @jakarta.persistence.Id
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String name;
//
//    private String type;
//
//    private String filePath;
//
//    @Builder
//    public FileData(String name, String type, String filePath) {
//        this.name = name;
//        this.type = type;
//        this.filePath = filePath;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Long getId() {
//        return id;
//    }
//}
