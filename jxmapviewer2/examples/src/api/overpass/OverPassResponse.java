package api.overpass;

import java.util.ArrayList;

public class OverPassResponse {
	Osm OsmObject;

	// Getter Methods

	public Osm getOsm() {
		return OsmObject;
	}

	// Setter Methods

	public void setOsm(Osm osmObject) {
		this.OsmObject = osmObject;
	}
}

class Osm {
	private String note;
	Meta MetaObject;
	ArrayList<Object> way = new ArrayList<Object>();
	private String _version;
	private String _generator;

	// Getter Methods

	public String getNote() {
		return note;
	}

	public Meta getMeta() {
		return MetaObject;
	}

	public String get_version() {
		return _version;
	}

	public String get_generator() {
		return _generator;
	}

	// Setter Methods

	public void setNote(String note) {
		this.note = note;
	}

	public void setMeta(Meta metaObject) {
		this.MetaObject = metaObject;
	}

	public void set_version(String _version) {
		this._version = _version;
	}

	public void set_generator(String _generator) {
		this._generator = _generator;
	}
}

class Meta {
	private String _osm_base;

	// Getter Methods

	public String get_osm_base() {
		return _osm_base;
	}

	// Setter Methods

	public void set_osm_base(String _osm_base) {
		this._osm_base = _osm_base;
	}
}