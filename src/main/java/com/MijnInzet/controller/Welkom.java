/*@author Peter Post
 *
 *        Doel programma
 *
 *
 */
package com.MijnInzet.controller;


import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableAutoConfiguration
public class Welkom {

    @RequestMapping("/hello")
    String home() {
        return "Welkom leden team 1 van cohort 15 Make It Work";
    }



}
