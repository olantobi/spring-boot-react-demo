/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.liferon.demo.repository;

import com.liferon.demo.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author olanrewaju.ebenezer
 */
public interface GroupRepository extends JpaRepository<Group, Long> {
    Group findByName(String name);
}
