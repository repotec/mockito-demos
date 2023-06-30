package com.mockito.demo.mock.annotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class SampleInjectMocksAnnotationTest {

	@Mock
	private Player player;
	
	@InjectMocks
	private Game game;
	
	@Test
	public void testWithWhenAndReturn() {
		when(player.getWeapon()).thenReturn("sword");
		
		assertEquals("Player attack with: sword", game.attack());
	}
	
	/**
	 * just different style
	 */
	@Test
	public void testWithGivenAndVerify() {
		given(player.getWeapon()).willReturn("sword");
		
		assertEquals("Player attack with: sword", game.attack());
		
		//verify that getWeapon has been called inside attack
		verify(player, times(1)).getWeapon();
	}
}


class Game {
    private Player player;

    public Game(Player player) {
        this.player = player;
    }

    public String attack() {
        return "Player attack with: " + player.getWeapon();
    }
}

class Player {
    private String weapon;

    public Player(String weapon) {
        this.weapon = weapon;
    }

    String getWeapon() {
        return weapon;
    }
}

