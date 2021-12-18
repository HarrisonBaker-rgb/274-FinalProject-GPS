

import java.awt.Color;

public enum enuState {
	UNSELECTED	(Color.WHITE),
	START		(Color.GREEN),
	PATH		(Color.BLUE),
	END			(Color.RED);
	
	private Color color;
	
	private enuState(Color c) {
		color = c;
	}
	
	public Color getColor() { return color; }
}
