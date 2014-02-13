package com.hatenablog.masquerade0324;

/**
 * Interface for a notifying of articles updates
 * @author meteorakey
 *
 */
public interface ArticleObserver {
	public abstract void update(ArticlesManager manager);
}
