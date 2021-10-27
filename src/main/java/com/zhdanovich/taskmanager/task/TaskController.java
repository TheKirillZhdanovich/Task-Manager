package com.zhdanovich.taskmanager.task;

import com.zhdanovich.taskmanager.appuser.AppUser;
import com.zhdanovich.taskmanager.appuser.AppUserRole;
import com.zhdanovich.taskmanager.appuser.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/user")
public class TaskController {

    private final TaskService taskService;
    private final AppUserService appUserService;

    @Autowired
    public TaskController(TaskService taskService, AppUserService appUserService) {
        this.taskService = taskService;
        this.appUserService = appUserService;
    }

    public Optional<AppUser> getCurrentUserRole() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getName();
        return appUserService.getAppUserByEmail(email);
    }

    @GetMapping()
    public String showTasks(Model model) {
        Optional<AppUser> userRole = getCurrentUserRole();

        if (userRole.get().getUserRole().equals(AppUserRole.ADMIN)) {
            model.addAttribute("tasks", taskService.show());
            return "tasks/admin_page";
        }
        else {
            model.addAttribute("tasks", taskService.show());
            return "tasks/user_page";
        }
    }

    @GetMapping("/new")
    public String createTask(Model model) {
        Task task = new Task();
        model.addAttribute("task", task);
        return "tasks/create_challenge";
    }

    @PostMapping()
    public String addTask(@ModelAttribute("task") Task task) {
        taskService.save(task);
        return "redirect:/user";
    }

    @GetMapping("/{id}")
    public String deleteStudent(@PathVariable("id") Long id) {
        taskService.delete(id);
        return "redirect:/user";
    }

}
