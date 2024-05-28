package com.challenge.filemanager.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "File")
public class FileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] byteArray;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getByteArray() {
        return byteArray;
    }

    public void setByteArray(byte[] byteArray) {
        this.byteArray = byteArray;
    }
}
