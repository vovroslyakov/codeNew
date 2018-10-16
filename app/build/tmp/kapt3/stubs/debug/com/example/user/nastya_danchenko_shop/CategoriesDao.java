package com.example.user.nastya_danchenko_shop;

import java.lang.System;

@android.arch.persistence.room.Dao()
@kotlin.Metadata(mv = {1, 1, 11}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\'J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\'\u00a8\u0006\u000b"}, d2 = {"Lcom/example/user/nastya_danchenko_shop/CategoriesDao;", "", "add", "", "category", "Lcom/example/user/nastya_danchenko_shop/Categories;", "all", "", "byId", "id", "", "app_debug"})
public abstract interface CategoriesDao {
    
    @android.arch.persistence.room.Insert()
    public abstract void add(@org.jetbrains.annotations.NotNull()
    com.example.user.nastya_danchenko_shop.Categories category);
    
    @org.jetbrains.annotations.NotNull()
    @android.arch.persistence.room.Query(value = "SELECT * FROM categories")
    public abstract java.util.List<com.example.user.nastya_danchenko_shop.Categories> all();
    
    @org.jetbrains.annotations.NotNull()
    @android.arch.persistence.room.Query(value = "SELECT * FROM categories WHERE id=:id")
    public abstract com.example.user.nastya_danchenko_shop.Categories byId(int id);
}