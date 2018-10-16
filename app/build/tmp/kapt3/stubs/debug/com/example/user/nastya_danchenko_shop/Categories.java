package com.example.user.nastya_danchenko_shop;

import java.lang.System;

@android.arch.persistence.room.Entity(tableName = "categories")
@kotlin.Metadata(mv = {1, 1, 11}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0002\u000f\u0010B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lcom/example/user/nastya_danchenko_shop/Categories;", "", "id", "", "name", "", "imageUrl", "url", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()I", "getImageUrl", "()Ljava/lang/String;", "getName", "getUrl", "$serializer", "Companion", "app_debug"})
@kotlinx.serialization.Serializable()
public final class Categories {
    @android.arch.persistence.room.PrimaryKey()
    private final int id = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String name = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String imageUrl = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String url = null;
    public static final com.example.user.nastya_danchenko_shop.Categories.Companion Companion = null;
    
    public final int getId() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getImageUrl() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUrl() {
        return null;
    }
    
    public Categories(int id, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String imageUrl, @org.jetbrains.annotations.NotNull()
    java.lang.String url) {
        super();
    }
    
    public Categories(int seen, @android.arch.persistence.room.PrimaryKey()
    int id, @org.jetbrains.annotations.Nullable()
    java.lang.String name, @org.jetbrains.annotations.Nullable()
    java.lang.String imageUrl, @org.jetbrains.annotations.Nullable()
    java.lang.String url, @org.jetbrains.annotations.Nullable()
    kotlinx.serialization.SerializationConstructorMarker serializationConstructorMarker) {
        super();
    }
    
    public void write$Self(@org.jetbrains.annotations.NotNull()
    kotlinx.serialization.KOutput output, @org.jetbrains.annotations.NotNull()
    kotlinx.serialization.KSerialClassDesc serialDesc) {
    }
    
    @kotlin.Metadata(mv = {1, 1, 11}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u00c6\u0001\u00a8\u0006\u0006"}, d2 = {"Lcom/example/user/nastya_danchenko_shop/Categories$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/example/user/nastya_danchenko_shop/Categories;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final kotlinx.serialization.KSerializer<com.example.user.nastya_danchenko_shop.Categories> serializer() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 1, 11}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003J\u0011\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\nH\u00d6\u0001J\u0019\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002H\u00d6\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VX\u00d6\u0005\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0010"}, d2 = {"com/example/user/nastya_danchenko_shop/Categories.$serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/example/user/nastya_danchenko_shop/Categories;", "()V", "serialClassDesc", "Lkotlinx/serialization/KSerialClassDesc;", "getSerialClassDesc", "()Lkotlinx/serialization/KSerialClassDesc;", "load", "input", "Lkotlinx/serialization/KInput;", "save", "", "output", "Lkotlinx/serialization/KOutput;", "obj", "app_debug"})
    public static final class $serializer implements kotlinx.serialization.KSerializer<com.example.user.nastya_danchenko_shop.Categories> {
        public static final com.example.user.nastya_danchenko_shop.Categories.$serializer INSTANCE = null;
        
        private $serializer() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public com.example.user.nastya_danchenko_shop.Categories update(@org.jetbrains.annotations.NotNull()
        kotlinx.serialization.KInput input, @org.jetbrains.annotations.NotNull()
        com.example.user.nastya_danchenko_shop.Categories old) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public kotlinx.serialization.KSerialClassDesc getSerialClassDesc() {
            return null;
        }
        
        @java.lang.Override()
        public void save(@org.jetbrains.annotations.NotNull()
        kotlinx.serialization.KOutput output, @org.jetbrains.annotations.NotNull()
        com.example.user.nastya_danchenko_shop.Categories obj) {
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public com.example.user.nastya_danchenko_shop.Categories load(@org.jetbrains.annotations.NotNull()
        kotlinx.serialization.KInput input) {
            return null;
        }
    }
}