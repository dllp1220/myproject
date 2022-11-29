package test5;
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
 
 private final Logger logger = LoggerFactory.getLogger(this.getClass());
 
 @Autowired
 AppUserDetailsService appUserDetailsService;   
 
 @Override
 protected void configure(AuthenticationManagerBuilder auth) throws Exception {
  auth
  .userDetailsService(appUserDetailsService)
  .passwordEncoder(new BCryptPasswordEncoder());
 }
 
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
  httpSecurity
    .authorizeRequests() // 認證機制設置              
     .antMatchers("/", "/home").permitAll() // 首頁不需認證
     .anyRequest().authenticated() // 除了以上的 URL 外, 都需要認證才可以訪問
     .and()
    .formLogin()
     .loginPage("/login") // 認證頁面指向頁頁
     .defaultSuccessUrl("/auth/home")
     .permitAll()
     .and()
    .logout()
     .permitAll();
  // disable page caching
        httpSecurity
                .headers()
                .frameOptions().sameOrigin()
                .cacheControl();
 }
    
 @Override
 public void configure(WebSecurity web) throws Exception {
  //allow anonymous resource requests
  web.ignoring().antMatchers("/fonts/**","/AdminLTE3/**");
 } 
}