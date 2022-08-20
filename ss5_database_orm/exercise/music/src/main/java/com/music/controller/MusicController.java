package com.music.controller;

import com.music.model.Music;
import com.music.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MusicController {
    @Autowired
    private IMusicService musicService;

    @GetMapping("/")
    public String goList(@RequestParam(required = false,defaultValue = "")String name, Model model) {
        List<Music> musicList = musicService.listMusic(name);
        model.addAttribute("musicList", musicList);
        return "list";
    }

    @GetMapping("/create")
    public String formCreate(Model model) {
        model.addAttribute("music", new Music());
        return "create";
    }

    @PostMapping("/create")
    public String addMusic(Music music) {
        musicService.addMusic(music);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String showUpdate(@PathVariable int id, Model model) {
        model.addAttribute("music", musicService.findById(id));
        return "update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Music music) {
        musicService.update(music);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int id) {
        musicService.delete(id);
        return "redirect:/";
    }


}
