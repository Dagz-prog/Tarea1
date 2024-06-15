package com.project.demo.logic.entity.product;

import com.project.demo.logic.entity.category.Category;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;


@Table(name = "product")
@Entity
public class Product  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    private double price;
    private int qtyStock;


    @CreationTimestamp
    @Column(updatable = false, name = "created_at")
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false)
    private Category category;


    //Constructores
    public Product() {}


    public String getName(){return name;}
    public String getDescription(){return description;}
    public double getPrice(){return price;}
    public int getQtyStock(){return qtyStock;}
    public Date getCreatedAt(){return createdAt;}
    public Date getUpdatedAt(){return updatedAt;}
    public Category getCategory(){return category;}
    public Long getId(){return id;}

    public void setId(Long id){this.id = id;}
    public void setName(String name){this.name = name;}
    public void setDescription(String description){this.description = description;}
    public void setPrice(double price){this.price = price;}
    public void setQtyStock(int qtyStock){this.qtyStock = qtyStock;}
    public void setCreatedAt(Date createdAt){this.createdAt = createdAt;}
    public void setUpdatedAt(Date updatedAt){this.updatedAt = updatedAt;}

    public Product setCategory(Category category){

        this.category = category;
        return this;

    }

}
