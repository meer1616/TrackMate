package fiji.plugin.trackmate.action;

import javax.swing.ImageIcon;

import net.imglib2.type.NativeType;
import net.imglib2.type.numeric.RealType;

import fiji.plugin.trackmate.Logger;
import fiji.plugin.trackmate.TrackMateModel;
import fiji.plugin.trackmate.TrackMate_;
import fiji.plugin.trackmate.gui.DisplayerPanel;

public class RecalculateFeatureAction<T extends RealType<T> & NativeType<T>> extends AbstractTMAction<T> {

	public static final ImageIcon ICON = new ImageIcon(DisplayerPanel.class.getResource("images/calculator.png"));
	public static final String NAME = "Recompute all spot features";
	public static final String INFO_TEXT = "<html>" +
			"Calling this action causes the model to recompute all the feautures <br>" +
			"for all the un-filtered spots." +
			"</html>";
	
	public RecalculateFeatureAction() {
		this.icon = ICON;
	}
	
	@Override
	public void execute(TrackMate_<T> plugin) {
		logger.log("Recalculating all features.\n");
		TrackMateModel<T> model = plugin.getModel();
		Logger oldLogger = model.getLogger();
		model.setLogger(logger);
		model.getFeatureModel().computeSpotFeatures(model.getSpots());
		model.setLogger(oldLogger);
		logger.log("Done.\n");
	}

	@Override
	public String getInfoText() {
		return INFO_TEXT;
	}
	
	@Override
	public String toString() {
		return NAME;
	}
}