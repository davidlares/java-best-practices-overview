package com.davidlares.aw.model;

import java.util.Date;

public interface IVisualizable {

	Date startedToSee(Date dateI); 
	void stopToSee(Date dateI, Date dateF);
}
