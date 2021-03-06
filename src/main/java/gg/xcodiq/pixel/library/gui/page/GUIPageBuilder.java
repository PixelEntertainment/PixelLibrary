/*
 * Licensed under the MIT License
 *
 * Copyright (c) 2021 Pixel Entertainment LLC
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package gg.xcodiq.pixel.library.gui.page;

import gg.xcodiq.pixel.library.gui.entry.GUIEntry;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class GUIPageBuilder {

	private final List<GUIEntry> entries = new ArrayList<>();

	private String title;
	private int rows;

	private boolean fillBorders = false;

	public GUIPageBuilder setTitle(String title) {
		this.title = title;
		return this;
	}

	public GUIPageBuilder setRows(int rows) {
		this.rows = rows;
		return this;
	}

	public GUIPageBuilder addItem(GUIEntry entry) {
		if (!entries.contains(entry)) entries.add(entry);
		return this;
	}

	public GUIPageBuilder fillBorders() {
		this.fillBorders = true;
		return this;
	}

	public GUIPage build() {
		GUIPage page = new GUIPage(this.title, this.rows) {
		};

		for (GUIEntry entry : this.entries) page.addItem(entry);

		return page;
	}
}
