package test5;

import java.util.logging.Logger;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class AppUserDetailsService implements UserDetailsService {
 private final Logger logger = LoggerFactory.getLogger(this.getClass());
 private static List<UserObject> users = new ArrayList(); 
 
 public AppUserDetailsService() {
  users.add(new UserObject("admin", "123", "ADMIN"));
        users.add(new UserObject("polinwei", "234", "USER"));
 }
 @Override
 public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
  Optional<UserObject> user = users.stream()
                .filter(u -> u.name.equals(username))
                .findAny();
  if (!user.isPresent()) {
  throw new UsernameNotFoundException("User not found by name: " + username);
  }
  return toUserDetails(user.get());
 }
 
    private static class UserObject {
        private String name;
        private String password;
        private String role;
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        public UserObject(String name, String password, String role) {
            this.name = name;
            this.password = passwordEncoder.encode(password);
            this.role = role;
        }
    }   
 
    private UserDetails toUserDetails(UserObject userObject) {      
  
        return User.withUsername(userObject.name)
                   .password(userObject.password)
                   .roles(userObject.role).build();
    }
    
}