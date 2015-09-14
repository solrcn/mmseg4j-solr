package com.chenlb.mmseg4j.analysis;

import java.io.File;

import org.apache.lucene.analysis.Analyzer;

import com.chenlb.mmseg4j.Dictionary;
import com.chenlb.mmseg4j.MaxWordSeg;
import com.chenlb.mmseg4j.Seg;

/**
 * 默认使用 max-word
 *
 * @see {@link SimpleAnalyzer}, {@link ComplexAnalyzer}, {@link MaxWordAnalyzer}
 *
 * @author chenlb
 */
public class MMSegAnalyzer extends Analyzer {

	protected Dictionary dic;

	/**
	 * @see Dictionary#getInstance()
	 */
	public MMSegAnalyzer() {
		dic = Dictionary.getInstance();
	}

	@Override
	protected TokenStreamComponents createComponents(String fieldName) {
		return new TokenStreamComponents(new MMSegTokenizer(newSeg()));
	}

	/**
	 * @param path 词库路径
	 * @see Dictionary#getInstance(String)
	 */
	public MMSegAnalyzer(String path) {
		dic = Dictionary.getInstance(path);
	}

	/**
	 * @param path 词库目录
	 * @see Dictionary#getInstance(File)
	 */
	public MMSegAnalyzer(File path) {
		dic = Dictionary.getInstance(path);
	}

	public MMSegAnalyzer(Dictionary dic) {
		super();
		this.dic = dic;
	}

	protected Seg newSeg() {
		return new MaxWordSeg(dic);
	}

	public Dictionary getDict() {
		return dic;
	}
}
