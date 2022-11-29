package test5;
@Controller
public class MainController {
 private final Logger logger = LoggerFactory.getLogger(this.getClass());
 private Authentication auth;
 @Autowired 
 UserDetailsService userDetailsService;
 @RequestMapping("/login")
 public String loginForm(HttpServletRequest request, Model model) {
  auth = SecurityContextHolder.getContext().getAuthentication();
  if (!auth.getPrincipal().equals("anonymousUser")) {
   return "auth-home";
  }
  return "login";
 }
  
 @RequestMapping("/auth/home")
 public String authHome(Model model) {
  auth = SecurityContextHolder.getContext().getAuthentication();
  model.addAttribute("username", auth.getName())
   .addAttribute("roles", auth.getAuthorities());
  return "auth-home";
 }
   
}