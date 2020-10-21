package com.codeup.springblogapp;

import com.codeup.springblogapp.services.UserDetailsLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private UserDetailsLoader usersLoader;

    public SecurityConfiguration(UserDetailsLoader usersLoader) {
        this.usersLoader = usersLoader;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(usersLoader) // How to find users by their username
                .passwordEncoder(passwordEncoder()) // How to encode and verify passwords
        ;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                /* Login configuration */
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/welcome") // user's home page, it can be any URL
                .permitAll() // Anyone can go to the login page

                /* Logout configuration */
                .and()
                .logout()
                .logoutSuccessUrl("/login?logout") // append a query string value

                /* Pages that can be viewed without having to log in */
                .and()
                .authorizeRequests()
                .antMatchers(
                        "/home",
                        "/welcome"
                ) // anyone can see the home and the ads pages
                .permitAll()

                /* Pages that require authentication */
                .and()
                .authorizeRequests()
                .antMatchers(
                        "/logout",
                        "/register",
                        "/ads",
                        "/posts",
                        "/ads/create", // only authenticated users can create ads
                        "/ads/{id}/edit", // only authenticated users can edit ads
                        "/posts/create", // only authenticated users can create posts
                        "/posts/{id}/edit", // only authenticated users can edit posts
                        "/roll_dice",
                        "/coffee_project/coffee",
                        "/breakout_game/breakout_index",
                        "/weather_map/weather_map",
                        "/text_adventure_game/text_adventure_game",
                        "/movie_database/movie_database",
                        "/capstone",
                        "https://quackertracker.com/",
                        "/react_tictactoe/react_tictactoe",
                        "/exoplanet/exoplanet",
                        "/superhero_database/superhero_database",
                        "/reactfox_tutorial/reactfox_tutorial",
                        "/rock_paper_scissors_tutorial/rock_paper_scissors_tutorial",
                        "/python_hangman/python_hangman,",
                        "/snake_tutorial/snake_tutorial",
                        "/java_pacman_tutorial/java_pacman_tutorial",
                        "/react_calculator/react_calculator",
                        "/memory_game/memory_game",
                        "react_compass_clock/react_compass_clock",
                        "/react_metronome/react_metronome",
                        "react_todo_tutorial",
                        "/react_piano/react_piano",
                        "/react_space_invaders/react_space_invaders",
                        "react_aliens_go_home/react_aliens_go_home",
                        "flappy_bird/flappy_bird",
                        "/javascript_tetris/javascript_tetris",
                        "/js_quiz_app/js_quiz_app",
                        "/javascript_pong/javascript_pong",
                        "/login"
// Enter Here ----->
                )
                .authenticated()
        ;
    }
}
