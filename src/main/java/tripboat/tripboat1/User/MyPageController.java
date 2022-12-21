package tripboat.tripboat1.User;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import tripboat.tripboat1.CommunityFile.Community;
import tripboat.tripboat1.CommunityFile.CommunityService;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class MyPageController {

    private final UserService userService;
    private final CommunityService communityService;

    @RequestMapping("/mypage")
    private String mypageform(Model model, Principal principal) {


        model.addAttribute("name",userService.getUser(principal.getName()));

//        model.addAttribute("user",principal);


        return "MyPage";
    }
}
