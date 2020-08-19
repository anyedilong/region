package com.region.moudles.system.dao;

import com.region.moudles.common.dao.BaseDao;
import com.region.moudles.common.domain.PageModel;
import com.region.moudles.system.dao.repository.SysRoleRepository;
import com.region.moudles.system.domain.SysRole;
import com.region.moudles.system.dto.SysRoleDto;
import com.region.until.StringUntil;

import java.util.List;

import javax.inject.Named;

@Named
public class SysRoleDao extends BaseDao<SysRoleRepository, SysRole>{

	/**
     *	 获取角色列表（分页）
     * @param sysRoleDto
     * @param page
     * @return
     */
    public void getRolePage(SysRoleDto sysRoleDto, PageModel page){
            StringBuffer sql = new StringBuffer();
    		sql.append(" select r.id id, r.role_name as roleName, r.remarks remarks, r.status as status, ")
    			.append(" (select org_name from sys_org where id = r.org_id and status = '1') as orgName  ")
    			.append(" from sys_role r ")
    			.append(" where r.delete_flg ='0' ");
    		if(!StringUntil.isNull(sysRoleDto.getOrgId())){
    			sql.append(" and (r.org_id in (select a.id from sys_org a start with a.parent_id = :orgId " + 
    						" connect by a.parent_id = prior a.id) or (r.org_id = :orgId)) ");
    		}
    		if(!StringUntil.isNull(sysRoleDto.getRoleName())){
    			sql.append(" and r.role_name like CONCAT('%',CONCAT(:roleName,'%')) ");
    		}
    		sql.append(" order by r.create_time desc ");
            queryPage(sql.toString(), sysRoleDto, page, SysRoleDto.class);
    }

    /**
     *	 获取角色列表
     * @param sysRoleDto
     * @return List<SysRoleDto>
     */
    public List<SysRoleDto> getRoleList(SysRoleDto sysRoleDto){
            StringBuffer sb=new StringBuffer();
            sb.append(" select r.id id, r.role_name roleName, r.remarks remarks, r.status as status ")
				.append(" from sys_role r ")
				.append(" where r.status ='1' and r.delete_flg ='0' ");
			if(!StringUntil.isNull(sysRoleDto.getOrgId())) {
				sb.append(" and r.org_id = :orgId ");
			}
            sb.append(" order by r.create_time desc ");
            return queryList(sb.toString(), sysRoleDto, SysRoleDto.class);
    }
    
    /**
     *	 根据角色名称和所属机构判断是否被占用
     * @param sysRole
     * @return SysRoleDto
     */
    public SysRoleDto queryRoleByNameOrgId(SysRole sysRole){
            StringBuffer sb=new StringBuffer();
            sb.append(" select r.id id, r.role_name roleName ")
				.append(" from sys_role r ")
				.append(" where r.status = '1' and r.delete_flg ='0' ");
            sb.append(" and r.org_id = :orgId and r.role_name = :roleName ");
            return queryOne(sb.toString(), sysRole, SysRoleDto.class);
    }
}
