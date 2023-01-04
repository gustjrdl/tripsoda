package tripboat.tripboat1.User;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tripboat.tripboat1.CommunityFile.Community;
import tripboat.tripboat1.CommunityFile.CommunityService;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class MyPageController {

    private final UserService userService;
    private final CommunityService communityService;

    @RequestMapping("/mypage")
    private String mypageform(Model model, Principal principal, @RequestParam(value="page", defaultValue="0") int page, @RequestParam(value = "kw", defaultValue = "") String kw) {

        Page<Community> community = this.communityService.getList(page,kw);


        model.addAttribute("name",userService.getUser(principal.getName()));
        model.addAttribute("community", community);


        return "MyPage";
    }
}
