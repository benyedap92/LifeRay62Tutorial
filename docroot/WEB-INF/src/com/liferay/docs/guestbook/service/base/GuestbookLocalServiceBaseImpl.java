/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.docs.guestbook.service.base;

import com.liferay.docs.guestbook.model.Guestbook;
import com.liferay.docs.guestbook.service.GuestbookLocalService;
import com.liferay.docs.guestbook.service.persistence.EntryPersistence;
import com.liferay.docs.guestbook.service.persistence.GuestbookPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.persistence.UserPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the guestbook local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.docs.guestbook.service.impl.GuestbookLocalServiceImpl}.
 * </p>
 *
 * @author benyedai
 * @see com.liferay.docs.guestbook.service.impl.GuestbookLocalServiceImpl
 * @see com.liferay.docs.guestbook.service.GuestbookLocalServiceUtil
 * @generated
 */
public abstract class GuestbookLocalServiceBaseImpl extends BaseLocalServiceImpl
	implements GuestbookLocalService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.liferay.docs.guestbook.service.GuestbookLocalServiceUtil} to access the guestbook local service.
	 */

	/**
	 * Adds the guestbook to the database. Also notifies the appropriate model listeners.
	 *
	 * @param guestbook the guestbook
	 * @return the guestbook that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Guestbook addGuestbook(Guestbook guestbook)
		throws SystemException {
		guestbook.setNew(true);

		return guestbookPersistence.update(guestbook);
	}

	/**
	 * Creates a new guestbook with the primary key. Does not add the guestbook to the database.
	 *
	 * @param guestbookId the primary key for the new guestbook
	 * @return the new guestbook
	 */
	@Override
	public Guestbook createGuestbook(long guestbookId) {
		return guestbookPersistence.create(guestbookId);
	}

	/**
	 * Deletes the guestbook with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param guestbookId the primary key of the guestbook
	 * @return the guestbook that was removed
	 * @throws PortalException if a guestbook with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Guestbook deleteGuestbook(long guestbookId)
		throws PortalException, SystemException {
		return guestbookPersistence.remove(guestbookId);
	}

	/**
	 * Deletes the guestbook from the database. Also notifies the appropriate model listeners.
	 *
	 * @param guestbook the guestbook
	 * @return the guestbook that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Guestbook deleteGuestbook(Guestbook guestbook)
		throws SystemException {
		return guestbookPersistence.remove(guestbook);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(Guestbook.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return guestbookPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.docs.guestbook.model.impl.GuestbookModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return guestbookPersistence.findWithDynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.docs.guestbook.model.impl.GuestbookModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return guestbookPersistence.findWithDynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return guestbookPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) throws SystemException {
		return guestbookPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public Guestbook fetchGuestbook(long guestbookId) throws SystemException {
		return guestbookPersistence.fetchByPrimaryKey(guestbookId);
	}

	/**
	 * Returns the guestbook with the matching UUID and company.
	 *
	 * @param uuid the guestbook's UUID
	 * @param  companyId the primary key of the company
	 * @return the matching guestbook, or <code>null</code> if a matching guestbook could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Guestbook fetchGuestbookByUuidAndCompanyId(String uuid,
		long companyId) throws SystemException {
		return guestbookPersistence.fetchByUuid_C_First(uuid, companyId, null);
	}

	/**
	 * Returns the guestbook matching the UUID and group.
	 *
	 * @param uuid the guestbook's UUID
	 * @param groupId the primary key of the group
	 * @return the matching guestbook, or <code>null</code> if a matching guestbook could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Guestbook fetchGuestbookByUuidAndGroupId(String uuid, long groupId)
		throws SystemException {
		return guestbookPersistence.fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the guestbook with the primary key.
	 *
	 * @param guestbookId the primary key of the guestbook
	 * @return the guestbook
	 * @throws PortalException if a guestbook with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Guestbook getGuestbook(long guestbookId)
		throws PortalException, SystemException {
		return guestbookPersistence.findByPrimaryKey(guestbookId);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return guestbookPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns the guestbook with the matching UUID and company.
	 *
	 * @param uuid the guestbook's UUID
	 * @param  companyId the primary key of the company
	 * @return the matching guestbook
	 * @throws PortalException if a matching guestbook could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Guestbook getGuestbookByUuidAndCompanyId(String uuid, long companyId)
		throws PortalException, SystemException {
		return guestbookPersistence.findByUuid_C_First(uuid, companyId, null);
	}

	/**
	 * Returns the guestbook matching the UUID and group.
	 *
	 * @param uuid the guestbook's UUID
	 * @param groupId the primary key of the group
	 * @return the matching guestbook
	 * @throws PortalException if a matching guestbook could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Guestbook getGuestbookByUuidAndGroupId(String uuid, long groupId)
		throws PortalException, SystemException {
		return guestbookPersistence.findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns a range of all the guestbooks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.docs.guestbook.model.impl.GuestbookModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of guestbooks
	 * @param end the upper bound of the range of guestbooks (not inclusive)
	 * @return the range of guestbooks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Guestbook> getGuestbooks(int start, int end)
		throws SystemException {
		return guestbookPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of guestbooks.
	 *
	 * @return the number of guestbooks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getGuestbooksCount() throws SystemException {
		return guestbookPersistence.countAll();
	}

	/**
	 * Updates the guestbook in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param guestbook the guestbook
	 * @return the guestbook that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Guestbook updateGuestbook(Guestbook guestbook)
		throws SystemException {
		return guestbookPersistence.update(guestbook);
	}

	/**
	 * Returns the entry local service.
	 *
	 * @return the entry local service
	 */
	public com.liferay.docs.guestbook.service.EntryLocalService getEntryLocalService() {
		return entryLocalService;
	}

	/**
	 * Sets the entry local service.
	 *
	 * @param entryLocalService the entry local service
	 */
	public void setEntryLocalService(
		com.liferay.docs.guestbook.service.EntryLocalService entryLocalService) {
		this.entryLocalService = entryLocalService;
	}

	/**
	 * Returns the entry remote service.
	 *
	 * @return the entry remote service
	 */
	public com.liferay.docs.guestbook.service.EntryService getEntryService() {
		return entryService;
	}

	/**
	 * Sets the entry remote service.
	 *
	 * @param entryService the entry remote service
	 */
	public void setEntryService(
		com.liferay.docs.guestbook.service.EntryService entryService) {
		this.entryService = entryService;
	}

	/**
	 * Returns the entry persistence.
	 *
	 * @return the entry persistence
	 */
	public EntryPersistence getEntryPersistence() {
		return entryPersistence;
	}

	/**
	 * Sets the entry persistence.
	 *
	 * @param entryPersistence the entry persistence
	 */
	public void setEntryPersistence(EntryPersistence entryPersistence) {
		this.entryPersistence = entryPersistence;
	}

	/**
	 * Returns the guestbook local service.
	 *
	 * @return the guestbook local service
	 */
	public com.liferay.docs.guestbook.service.GuestbookLocalService getGuestbookLocalService() {
		return guestbookLocalService;
	}

	/**
	 * Sets the guestbook local service.
	 *
	 * @param guestbookLocalService the guestbook local service
	 */
	public void setGuestbookLocalService(
		com.liferay.docs.guestbook.service.GuestbookLocalService guestbookLocalService) {
		this.guestbookLocalService = guestbookLocalService;
	}

	/**
	 * Returns the guestbook remote service.
	 *
	 * @return the guestbook remote service
	 */
	public com.liferay.docs.guestbook.service.GuestbookService getGuestbookService() {
		return guestbookService;
	}

	/**
	 * Sets the guestbook remote service.
	 *
	 * @param guestbookService the guestbook remote service
	 */
	public void setGuestbookService(
		com.liferay.docs.guestbook.service.GuestbookService guestbookService) {
		this.guestbookService = guestbookService;
	}

	/**
	 * Returns the guestbook persistence.
	 *
	 * @return the guestbook persistence
	 */
	public GuestbookPersistence getGuestbookPersistence() {
		return guestbookPersistence;
	}

	/**
	 * Sets the guestbook persistence.
	 *
	 * @param guestbookPersistence the guestbook persistence
	 */
	public void setGuestbookPersistence(
		GuestbookPersistence guestbookPersistence) {
		this.guestbookPersistence = guestbookPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();

		PersistedModelLocalServiceRegistryUtil.register("com.liferay.docs.guestbook.model.Guestbook",
			guestbookLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.liferay.docs.guestbook.model.Guestbook");
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	@Override
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	@Override
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	@Override
	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	protected Class<?> getModelClass() {
		return Guestbook.class;
	}

	protected String getModelClassName() {
		return Guestbook.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = guestbookPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.liferay.docs.guestbook.service.EntryLocalService.class)
	protected com.liferay.docs.guestbook.service.EntryLocalService entryLocalService;
	@BeanReference(type = com.liferay.docs.guestbook.service.EntryService.class)
	protected com.liferay.docs.guestbook.service.EntryService entryService;
	@BeanReference(type = EntryPersistence.class)
	protected EntryPersistence entryPersistence;
	@BeanReference(type = com.liferay.docs.guestbook.service.GuestbookLocalService.class)
	protected com.liferay.docs.guestbook.service.GuestbookLocalService guestbookLocalService;
	@BeanReference(type = com.liferay.docs.guestbook.service.GuestbookService.class)
	protected com.liferay.docs.guestbook.service.GuestbookService guestbookService;
	@BeanReference(type = GuestbookPersistence.class)
	protected GuestbookPersistence guestbookPersistence;
	@BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
	protected com.liferay.counter.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
	protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
	@BeanReference(type = com.liferay.portal.service.UserLocalService.class)
	protected com.liferay.portal.service.UserLocalService userLocalService;
	@BeanReference(type = com.liferay.portal.service.UserService.class)
	protected com.liferay.portal.service.UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private GuestbookLocalServiceClpInvoker _clpInvoker = new GuestbookLocalServiceClpInvoker();
}