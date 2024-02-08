/*-
 * #%L
 * TrackMate: your buddy for everyday tracking.
 * %%
 * Copyright (C) 2010 - 2024 TrackMate developers.
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */
package fiji.plugin.trackmate.gui.components;

import java.awt.event.ActionEvent;
import java.util.Map;

import javax.swing.JPanel;

/**
 * The mother class for all the configuration panels.
 * 
 * @author Jean-Yves Tinevez
 *
 */
public abstract class ConfigurationPanel extends JPanel
{

	private static final long serialVersionUID = 1L;

	/**
	 * This event is fired when a preview button is fired within this
	 * configuration panel. It is the responsibility of concrete implementation
	 * to do whatever they want with it.
	 */
	public final ActionEvent PREVIEW_BUTTON_PUSHED = new ActionEvent( this, 0, "PreviewButtonPushed" );

	/**
	 * Echoes the parameters of the given settings on this panel.
	 * 
	 * @param settings
	 *            the settings as a map.
	 */
	public abstract void setSettings( final Map< String, Object > settings );

	/**
	 * Returns a new settings map of string-object with its values set by this
	 * panel.
	 * 
	 * @return a new map.
	 */
	public abstract Map< String, Object > getSettings();

	/**
	 * Executes any task related to cleaning the possible previews generated by
	 * this panel prior to moving to another GUI panel.
	 */
	public abstract void clean();

}
