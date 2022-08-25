package com.music.controller;

import com.music.dto.MusicDto;
import com.music.model.Music;
import com.music.service.IMusicService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class MusicController {
    @Autowired
    private IMusicService musicService;

    @GetMapping("/music")
    public String goList(Model model) {
        List<Music> musicList = musicService.findAll();
        model.addAttribute("musicList", musicList);
        return "list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("musicDto", new MusicDto());
        return "/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute
                         @Valid MusicDto musicDto,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes,
                         Model model) {
        new MusicDto().validate(musicDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "create";
        }
        Music music = new Music();
        BeanUtils.copyProperties(musicDto, music);
        model.addAttribute("musicDto", musicDto);
        musicService.save(music);
        redirectAttributes.addFlashAttribute("msg", "Register successfully!");
        return "redirect:/music";
    }

    @GetMapping("/update/{id}")
    public String showUpdate(@PathVariable Integer id, Model model) {
        model.addAttribute("musicDto", musicService.findById(id));
        return "update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Music music,
                         @Valid MusicDto musicDto,
                         BindingResult bindingResult) {
        new MusicDto().validate(musicDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "update";
        }
        musicService.save(music);
        return "redirect:/music";
    }
}
