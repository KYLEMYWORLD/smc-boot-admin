package com.kyle.basic.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author kyle
 * @date 2024/5/7
 */
@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = "bas_user_post")
public class BasUserPost implements Serializable {
    @Column(name = "user_id")
    @Id
    private String userId;
    @Id
    @Column(name = "post_id")
    private String postId;
}
