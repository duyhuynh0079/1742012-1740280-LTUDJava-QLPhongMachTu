package show;

import javax.swing.DefaultComboBoxModel;

public class DonViTinhThuocComboModel extends DefaultComboBoxModel<String>{
	public DonViTinhThuocComboModel(String[] items) {
		super(items);
	}

	@Override
	public String getSelectedItem() {
		String selectedJob = (String) super.getSelectedItem();

		// do something with this job before returning...

		return selectedJob;
	}
}
